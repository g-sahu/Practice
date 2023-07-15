package com.interviews.teya;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PaymentProcessor {
    private static final Map<String, BigDecimal> PROCESSING_FEE_MAP;
    private static final String COLON = ":";
    public static final String COMMA = ",";

    static {
        Map<String, BigDecimal> map = new HashMap<>(3);
        map.put("GBP", BigDecimal.valueOf(0.0033).setScale(4, RoundingMode.HALF_UP));
        map.put("EUR", BigDecimal.valueOf(0.0050).setScale(4, RoundingMode.HALF_UP));
        map.put("CZK", BigDecimal.valueOf(0.0050).setScale(4, RoundingMode.HALF_UP));
        PROCESSING_FEE_MAP = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        String payments = "GBP:100,EUR:200,CZK:1000|743:EUR:5.76,932:GBP:32.10,909:CZK:223.26,23:CZK:890.22,902:GBP:58.23,89:EUR:104.25,663:EUR:97.43,902:EUR:20.01";
        System.out.println(GeneratePaymentBatches(payments));
    }

    public static String GeneratePaymentBatches(String fundsAndPayments) {
        String[] arr = fundsAndPayments.split("\\|");
        Map<String, BigDecimal> fundsMap = buildFundsMap(arr[0]);
        List<Payment> payments = buildPayments(arr[1]);
        Map<String, List<Payment>> batches = buildBatches(fundsMap, payments);

        //Convert to String output
        return convertToString(batches);
    }

    private static Map<String, List<Payment>> buildBatches(Map<String, BigDecimal> fundsMap, List<Payment> payments) {
        Map<String, List<Payment>> batches = payments.stream()
                                                     .map(PaymentProcessor :: deductProcessingFee)
                                                     .collect(Collectors.groupingBy(Payment :: getCurrency, TreeMap :: new, Collectors.toList()));

        Map<String, List<Payment>> paymentBatches = new TreeMap<>();

        //Filter out payments
        batches.forEach((currency, paymentList) -> {
            BigDecimal totalFunds = fundsMap.get(currency);
            List<Payment> filteredPayments = new ArrayList<>();

            for (Payment payment: paymentList) {
                BigDecimal remainingFunds = totalFunds.subtract(payment.getPayableAmount());

                if (remainingFunds.compareTo(BigDecimal.ZERO) > 0) {
                    filteredPayments.add(payment);
                    totalFunds = remainingFunds;
                }
            }

            paymentBatches.put(currency, filteredPayments);
        });

        return paymentBatches;
    }

    private static Payment deductProcessingFee(Payment payment) {
        String currency = payment.getCurrency();
        BigDecimal fee = payment.getAmount().multiply(PROCESSING_FEE_MAP.get(currency)).setScale(4, RoundingMode.HALF_UP);
        BigDecimal payableAmount = payment.getAmount().subtract(fee);
        payment.setPayableAmount(payableAmount);
        return payment;
    }

    private static Map<String, BigDecimal> buildFundsMap(String funds) {
        String[] fundsArr = funds.split(COMMA);

        return Arrays.stream(fundsArr)
                     .map(string -> string.split(COLON))
                     .collect(Collectors.toMap(arr -> arr[0], arr -> new BigDecimal(arr[1])));
    }

    private static List<Payment> buildPayments(String payments) {
        String[] paymentsArr = payments.split(COMMA);

        return Arrays.stream(paymentsArr)
                     .map(paymentString -> paymentString.split(COLON))
                     .map(arr -> new Payment(arr[0], arr[1], new BigDecimal(arr[2])))
                     .sorted(Payment :: compareTo)
                     .collect(Collectors.toList());
    }

    private static String convertToString(Map<String, List<Payment>> paymentBatches) {
        return paymentBatches.entrySet()
                             .stream()
                             .map(entry -> {
                                 String currency = entry.getKey();
                                 List<Payment> paymentList = entry.getValue();
                                 String payments = paymentList.stream()
                                                              .map(Payment :: toString)
                                                              .collect(Collectors.joining("\n"));

                                 return currency + "\n" + payments;
                             })
                             .collect(Collectors.joining("\n"));
    }
}

//TODO: Create a PaymentParser class

class Payment implements Comparable<Payment> {
    private final String merchantId;
    private final String currency;
    private final BigDecimal amount;
    private BigDecimal payableAmount;

    Payment(String merchantId, String currency, BigDecimal amount) {
        this.merchantId = merchantId;
        this.currency = currency;
        this.amount = amount.setScale(4, RoundingMode.HALF_UP);
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    @Override
    public int compareTo(Payment payment) {
        return Comparator.comparing(Payment :: getCurrency)
                         .thenComparing(Payment :: getAmount)
                         .compare(this, payment);
    }

    @Override
    public String toString() {
        return String.join(":", merchantId, currency, payableAmount.toString());
    }
}

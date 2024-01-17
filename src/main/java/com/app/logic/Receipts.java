package com.app.logic;

import com.app.logic.models.Receipt;

import java.util.HashMap;
import java.util.Map;

public class Receipts {
    public static final Receipts instance = new Receipts();
    private Receipts(){};
    public Map<Integer, Receipt> receiptsMap = new HashMap<>();
    public Receipt getReceiptById(Integer id) {
        return receiptsMap.get(id);
    }

}

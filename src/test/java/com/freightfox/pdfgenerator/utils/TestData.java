package com.freightfox.pdfgenerator.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freightfox.pdfgenerator.entity.BuyerSellerDetails;

public class TestData {

    public static final String buyerSellerDetailsString = """
            {
                "seller": "XYZ Pvt. Ltd.",
                "sellerGstin": "46KZAHM6385P6Z2",
                "sellerAddress": "New Delhi, India",
                "buyer": "Vedant Computers",
                "buyerGstin": "16BZAHM6385P6Z2",
                "buyerAddress": "New Delhi, India",
                "items": [
                    {
                        "name": "Product 2",
                        "quantity": "2 Nos",
                        "rate": 222.00,
                        "amount": 2222.00
                    }
                ]
            }
            """;

    public static final String invalidBuyerSellerDetailsString = """
            {
                "seller": "XYZ Pvt. Ltd. XXX XXX XXXX XXXX XXXX XXXX XXX",
                "sellerGstin": "46ZAHM6385P6Z2",
                "sellerAddress": "New Delhi, India",
                "buyer": "Vedant Computers YYYY YYYYY YYYYYY YYYYYY YYYYY",
                "buyerGstin": "1BZAHM6385P6Z22",
                "buyerAddress": "New Delhi, India",
                "items": [
                    {
                        "name": "Product 2",
                        "quantity": "2 Nos",
                        "rate": 222.00,
                        "amount": 2222.00
                    }
                ]
            }
            """;

    public static String generatedHtmlString = """
            <!DOCTYPE html>
            <html>
            <head>
            <!--    pdf generator having some issue with picking the static files so moved style here-->
                <style>
                    html {
                       display: table;
                       margin: auto;
                    }
                        
                    body {
                       width: 100%;
                    }
                        
                    .outer-container{
                       display: flex;
                       justify-content: center;
                       flex-direction: column;
                       margin: auto;
                       margin-top: 20px;
                       width: 650px;
                       border: 1px solid black;
                       border-collapse: collapse;
                    }
                        
                    .details-header {
                       display: flex;
                       flex-direction: row;
                    }
                        
                    .detail-container{
                       padding: 30px;
                       border: 1px solid black;
                       border-bottom: none;
                       border-collapse: collapse;
                       width: 50%;
                    }
                        
                        
                    .item-table{
                       border: 1px solid black;
                       border-collapse: collapse;
                    }
                        
                    .item-table th, .item-table td {
                       text-align: center;
                       border: 1px solid black;
                       border-collapse: collapse;
                       padding: 5px;
                    }
                        
                    .details-footer{
                       height: 80px;
                       border: 1px solid black;
                       border-collapse: collapse;
                    }
                        
                    p {
                       margin: 0em;
                    }
                </style>
            </head>
                        
            <body>
                        
            <div class="outer-container">
                <div class="details-header">
                    <div class="detail-container">
                        <p><b>Seller:</b></p>
                        <p>XYZ Pvt. Ltd.</p>
                        <p>New Delhi, India</p>
                        <p>GSTIN: <span>46KZAHM6385P6Z2</span></p>
                    </div>
                    <div class="detail-container">
                        <p><b>Buyer:</b></p>
                        <p>Vedant Computers</p>
                        <p>New Delhi, India</p>
                        <p>GSTIN: <span>16BZAHM6385P6Z2</span></p>
                    </div>
                </div>
                <table class="item-table">
                    <tr>
                        <th>Item</th>
                        <th>Quantity</th>
                        <th>Rate</th>
                        <th>Amount</th>
                    </tr>
                    <tr>
                        <td>Product 2</td>
                        <td>2 Nos</td>
                        <td>222.0</td>
                        <td>2222.0</td>
                    </tr>
                </table>
                <div class="details-footer"></div>
            </div>
                        
                        
            </body>
                        
            </html>""";

    public static BuyerSellerDetails getBuyerSellerDetails() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(buyerSellerDetailsString, BuyerSellerDetails.class);
        } catch (JsonProcessingException e) {
            return new BuyerSellerDetails();
        }
    }
}

package com.freightfox.pdfgenerator.exception;


public class PdfGenerationFailedException extends RuntimeException{

    public PdfGenerationFailedException(String message){
        super(message);
    }
}

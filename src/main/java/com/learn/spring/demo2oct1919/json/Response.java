package com.learn.spring.demo2oct1919.json;

public class Response {

    private Result[] results;

    private String status;

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Location getlocation(){

        System.out.println("length..." + results.length);
        return  results[0].getGeometry().getLocation();
    }

    public String getFormattedAddress() {
        return results[0].getFormattedAddress();
    }
}

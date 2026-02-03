package com.streamapi.insuranceclaim;

class InsuranceClaim {
    private String claimType;
    private double claimAmount;
    public InsuranceClaim(String claimType, double claimAmount) {
        this.claimType=claimType;
        this.claimAmount=claimAmount;
    }

    public String getClaimType() {
        return claimType;
    }

    public double getClaimAmount() {
        return claimAmount;
    }
}

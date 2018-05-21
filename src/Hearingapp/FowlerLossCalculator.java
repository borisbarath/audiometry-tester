package Hearingapp;

public class FowlerLossCalculator implements EarCalculator {


  @Override
  public Double getValueThisEar(EarModel earModel) {

    return (earModel.getFreq500hz() + earModel.getFreq1000hz()
        + earModel.getFreq2000hz() + earModel.getFreq4000hz());
  }

  @Override
  public float getTotalValue(EarModel leftEar, EarModel rightEar) {
    Double leftLoss = getValueThisEar(leftEar);
    Double rightLoss = getValueThisEar(rightEar);
    if (leftLoss > rightLoss) {
      return (Math.round((((leftLoss - rightLoss) / 4.0) + rightLoss) * 1000) / 1000);
    } else {
      return (Math.round((((rightLoss - leftLoss) / 4.0) + leftLoss) * 1000) / 1000);
    }
  }
}
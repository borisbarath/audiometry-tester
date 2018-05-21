package Hearingapp;

public interface EarCalculator {

  Double getValueThisEar(EarModel ear);

  float getTotalValue(EarModel leftEar, EarModel rightEar);
}

package Hearingapp;

public class EarModel {

  // Strategy for calculating values for ear
  private EarCalculator calc;
  private Double freq500hz, freq1000hz, freq2000hz, freq4000hz;


  public Double getFreq500hz() {
    return freq500hz;
  }

  public Double getFreq1000hz() {
    return freq1000hz;
  }

  public Double getFreq2000hz() {
    return freq2000hz;
  }

  public Double getFreq4000hz() {
    return freq4000hz;
  }

  public EarModel(Double freq500hz, Double freq1000hz, Double freq2000hz, Double freq4000hz, EarCalculator calc) {
    this.calc = calc;
	  this.freq500hz = freq500hz;
	  this.freq1000hz = freq1000hz;
	  this.freq2000hz = freq2000hz;
	  this.freq4000hz = freq4000hz;
  }

  public Double getValueThisEar() {
	  return calc.getValueThisEar(this);
  }

  public float getTotalValue(EarModel nextEar) {
    return calc.getTotalValue(this, nextEar);
  }
}

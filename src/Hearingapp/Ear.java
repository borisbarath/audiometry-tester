package Hearingapp;

import static Hearingapp.Utils.getCorrespondingValue;

public class Ear {

  private Double freq500hz, freq1000hz, freq2000hz, freq4000hz;

  public Ear(int freq500hz, int freq1000hz, int freq2000hz, int freq4000hz) {
    this.freq500hz = getCorrespondingValue(Frequency.F500, freq500hz);
    this.freq1000hz = getCorrespondingValue(Frequency.F1000, freq1000hz);
    this.freq2000hz = getCorrespondingValue(Frequency.F2000, freq2000hz);
    this.freq4000hz = getCorrespondingValue(Frequency.F4000, freq4000hz);
  }

  public Double getLossThisEar() {
    return (freq500hz + freq1000hz + freq2000hz) / 3;
  }

}

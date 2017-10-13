package Hearingapp;

public class Ear {

  private int freq500hz, freq1000hz, freq2000hz;


  public Ear(int freq500hz, int freq1000hz, int freq2000hz) {
    this.freq500hz = freq500hz;
    this.freq1000hz = freq1000hz;
    this.freq2000hz = freq2000hz;
  }

  public int getFreq500hz() {
    return freq500hz;
  }

  public int getFreq1000hz() {
    return freq1000hz;
  }

  public int getFreq2000hz() {
    return freq2000hz;
  }

  public int getLossThisEar() {
    return (freq500hz + freq1000hz + freq2000hz) / 3;
  }

}

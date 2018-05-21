package Hearingapp;

public class AppData {

  protected final Double[] loss500 = {0.2, 0.5, 1.1, 1.8, 2.6, 3.7, 4.9, 6.4, 7.9,
      9.6, 11.3, 12.8, 13.8, 14.6, 14.8, 14.9, 15.0, 15.0};
  protected final Double[] loss1k = {0.3, 0.9, 2.1, 3.6, 5.4, 7.7, 10.2, 13.0,
      15.7, 19.0, 21.5, 23.5, 25.5, 27.2, 28.8, 29.8, 29.9, 30.0};
  protected final Double[] loss2k = {0.4, 1.3, 2.9, 4.9, 7.2, 9.8, 12.9, 17.3, 22.4,
      25.7, 28.0, 30.2, 32.2, 34.0, 35.8, 37.5, 39.2, 40.0};
  protected final Double[] loss4k = {0.1, 0.3, 0.9, 1.7, 2.7, 3.8, 5.0, 6.4, 8.0, 9.7,
      11.2, 12.5, 13.5, 14.2, 14.6, 14.8, 14.9, 15.0};

  private Double[][] lists = {loss500, loss1k, loss2k, loss4k};
  private String[] labels = {" 500", "1000", "2000", "4000"};

  public String[] getLabels() {
    return labels;
  }

  //lists for easier generation of items
  private String[] boxnames = {"left500", "left1k", "left2k", "left4k",
      "right500", "right1k", "right2k", "right4k"};

  public String[] getBoxnames() {
    return boxnames;
  }

  //list of values for dropdown boxes
  private Integer[] decibel = {10, 15, 20, 25, 30, 35, 40, 45, 50,
      55, 60, 65, 70, 75, 80, 85, 90, 95};

  public Integer[] getDecibel() {
    return decibel;
  }

  //loss percentage values
  private Double l5;

  public Double getL5() {
    return l5;
  }

  public void setL5(Double l5) {
    this.l5 = l5;
  }

  private Double l1;

  public Double getL1() {
    return l1;
  }

  public void setL1(Double l1) {
    this.l1 = l1;
  }

  private Double l2;

  public Double getL2() {
    return l2;
  }

  public void setL2(Double l2) {
    this.l2 = l2;
  }

  private Double l4;

  public Double getL4() {
    return l4;
  }

  public void setL4(Double l4) {
    this.l4 = l4;
  }

  private Double r5;

  public Double getR5() {
    return r5;
  }

  public void setR5(Double r5) {
    this.r5 = r5;
  }

  private Double r1;

  public Double getR1() {
    return r1;
  }

  public void setR1(Double r1) {
    this.r1 = r1;
  }

  private Double r2;

  public Double getR2() {
    return r2;
  }

  public void setR2(Double r2) {
    this.r2 = r2;
  }

  private Double r4;

  public Double getR4() {
    return r4;
  }

  public void setR4(Double r4) {
    this.r4 = r4;
  }
}
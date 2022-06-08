package finalExam.p3;

public class ReplacementInfo {
  private long numOccurrences;
  private String sourceStr;
  private String destStr;

  public ReplacementInfo(String sourceStr, String destStr, long numOccurrences) {
    this.numOccurrences = numOccurrences;
    this.sourceStr = sourceStr;
    this.destStr = destStr;
  }

  public void setNumOccurrences(long numOccurrences) {
    this.numOccurrences = numOccurrences;
  }

  public long getNumOccurrences() {
    return numOccurrences;
  }

  public String getSourceStr() {
    return sourceStr;
  }

  public void setSourceStr(String sourceStr) {
    this.sourceStr = sourceStr;
  }

  public String getDestStr() {
    return destStr;
  }

  public void setDestStr(String destStr) {
    this.destStr = destStr;
  }



  @Override
  public String toString() {
    return sourceStr + ", " + destStr + ", " + numOccurrences + "\n";
  }
}

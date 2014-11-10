package util;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class RetrievalMeasures {
  /**
   * Calculate Precision
   * @param goldStand
   * @param ret
   * @return
   */
  public static<T> double precision(List<T> goldStand,List<T> ret ) {
    HashSet<T> gold = new HashSet<T>(goldStand);
    int positiveTrue = 0;
    for (T retrieved : ret) {
      if (gold.contains(retrieved)) {
        positiveTrue++; // find one in gold standard output true 
      }
    }
    return (double)positiveTrue/ret.size();
  }
  
  /**
   * Calculate Recall
   * @param goldStand
   * @param ret
   * @return
   */
  public static<T> double recall(List<T> goldStand,List<T> ret ) {
    HashSet<T> gold = new HashSet<T>(goldStand);
    int positiveTrue = 0;
    for (T retrieved : ret) {
      if (gold.contains(retrieved)) {
        positiveTrue++; // find one in gold standard output true 
      }
    }
    return (double)positiveTrue/goldStand.size();
  }
  
  /**
   * Calculate Average Precision
   * @param goldStand
   * @param ret
   * @return
   */
  public static<T> double avgPreision(List<T> goldStand,List<T> ret){
    ArrayList<Double> p = new ArrayList<>();
    HashSet<T> gold = new HashSet<T>(goldStand);
    int relevantCount = 0; // number of relevant items
    T retrieved;
    for (int i = 0; i < ret.size(); i++) {
      retrieved = ret.get(i);
      if (gold.contains(retrieved)) {
        relevantCount++;
        p.add((double)relevantCount/(i+1)); // add P@n
      }
    }
    if (p.size() == 0)
      return 0.0;
    else {
      double sum = 0;
      for (Double precision : p) {
        sum += precision;
      }
      return sum/p.size();
    }
  }
  
  /**
   * Calculate Mean Average Precision
   * @param ap
   * @return
   */
  public static<T> double MAP(double[] ap) {
    double sum = 0;
    for (int i = 0; i < ap.length; i++) {
      sum += ap[i];
    }
    return sum/ap.length;
  }
  
  /**
   * Calculate Geometric Mean Average
   * @param ap
   * @return
   */
  public static<T> double GMAP(double[] ap) {
    double product = 1.0;
    for (int i = 0; i < ap.length; i++) {
      product *= Math.pow(ap[i], 1.0 / ap.length);
    }
    return product;
  }
}

package edu.cmu.lti.f14.project.annotator;

import java.io.IOException;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.lti.oaqa.type.input.Question;


public class QueryAnnotator extends JCasAnnotator_ImplBase {
  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {

    FSIterator<Annotation> iter = jcas.getAnnotationIndex().iterator();
    if (iter.isValid()) {
      iter.moveToNext();
      Question question = (Question) iter.get();
      createTermFreqVector(jcas, question);
    }

  }

  private void createTermFreqVector(JCas aJCas, Question question) {
    // TODO Auto-generated method stub
    FSIterator<Annotation> iter = aJCas.getAnnotationIndex(Question.type).iterator();
    
    
    
    
  }
}

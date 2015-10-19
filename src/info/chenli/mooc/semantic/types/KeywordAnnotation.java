

/* First created by JCasGen Thu Sep 24 16:57:37 EDT 2015 */
package info.chenli.mooc.semantic.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Oct 19 16:33:46 EDT 2015
 * XML source: /data/sls/u/cli/projects/mooc/code/desc/TranscriptionAnnotator.xml
 * @generated */
public class KeywordAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(KeywordAnnotation.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected KeywordAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public KeywordAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public KeywordAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public KeywordAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: score

  /** getter for score - gets 
   * @generated
   * @return value of the feature 
   */
  public float getScore() {
    if (KeywordAnnotation_Type.featOkTst && ((KeywordAnnotation_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "info.chenli.mooc.semantic.types.KeywordAnnotation");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((KeywordAnnotation_Type)jcasType).casFeatCode_score);}
    
  /** setter for score - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setScore(float v) {
    if (KeywordAnnotation_Type.featOkTst && ((KeywordAnnotation_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "info.chenli.mooc.semantic.types.KeywordAnnotation");
    jcasType.ll_cas.ll_setFloatValue(addr, ((KeywordAnnotation_Type)jcasType).casFeatCode_score, v);}    
  }

    


/* First created by JCasGen Thu Sep 24 11:05:28 EDT 2015 */
package info.chenli.mooc.semantic.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Oct 20 14:15:35 EDT 2015
 * XML source: /data/sls/u/cli/projects/mooc/code/desc/TranscriptionAnnotator.xml
 * @generated */
public class Transcription extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Transcription.class);
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
  protected Transcription() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Transcription(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Transcription(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Transcription(JCas jcas, int begin, int end) {
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
  //* Feature: startTime

  /** getter for startTime - gets 
   * @generated
   * @return value of the feature 
   */
  public long getStartTime() {
    if (Transcription_Type.featOkTst && ((Transcription_Type)jcasType).casFeat_startTime == null)
      jcasType.jcas.throwFeatMissing("startTime", "info.chenli.mooc.semantic.types.Transcription");
    return jcasType.ll_cas.ll_getLongValue(addr, ((Transcription_Type)jcasType).casFeatCode_startTime);}
    
  /** setter for startTime - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setStartTime(long v) {
    if (Transcription_Type.featOkTst && ((Transcription_Type)jcasType).casFeat_startTime == null)
      jcasType.jcas.throwFeatMissing("startTime", "info.chenli.mooc.semantic.types.Transcription");
    jcasType.ll_cas.ll_setLongValue(addr, ((Transcription_Type)jcasType).casFeatCode_startTime, v);}    
   
    
  //*--------------*
  //* Feature: endTime

  /** getter for endTime - gets 
   * @generated
   * @return value of the feature 
   */
  public long getEndTime() {
    if (Transcription_Type.featOkTst && ((Transcription_Type)jcasType).casFeat_endTime == null)
      jcasType.jcas.throwFeatMissing("endTime", "info.chenli.mooc.semantic.types.Transcription");
    return jcasType.ll_cas.ll_getLongValue(addr, ((Transcription_Type)jcasType).casFeatCode_endTime);}
    
  /** setter for endTime - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setEndTime(long v) {
    if (Transcription_Type.featOkTst && ((Transcription_Type)jcasType).casFeat_endTime == null)
      jcasType.jcas.throwFeatMissing("endTime", "info.chenli.mooc.semantic.types.Transcription");
    jcasType.ll_cas.ll_setLongValue(addr, ((Transcription_Type)jcasType).casFeatCode_endTime, v);}    
   
    
  //*--------------*
  //* Feature: Index

  /** getter for Index - gets 
   * @generated
   * @return value of the feature 
   */
  public int getIndex() {
    if (Transcription_Type.featOkTst && ((Transcription_Type)jcasType).casFeat_Index == null)
      jcasType.jcas.throwFeatMissing("Index", "info.chenli.mooc.semantic.types.Transcription");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Transcription_Type)jcasType).casFeatCode_Index);}
    
  /** setter for Index - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setIndex(int v) {
    if (Transcription_Type.featOkTst && ((Transcription_Type)jcasType).casFeat_Index == null)
      jcasType.jcas.throwFeatMissing("Index", "info.chenli.mooc.semantic.types.Transcription");
    jcasType.ll_cas.ll_setIntValue(addr, ((Transcription_Type)jcasType).casFeatCode_Index, v);}    
  }

    
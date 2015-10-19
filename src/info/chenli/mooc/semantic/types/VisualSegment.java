

/* First created by JCasGen Mon Oct 19 14:51:56 EDT 2015 */
package info.chenli.mooc.semantic.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Oct 19 16:33:46 EDT 2015
 * XML source: /data/sls/u/cli/projects/mooc/code/desc/TranscriptionAnnotator.xml
 * @generated */
public class VisualSegment extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(VisualSegment.class);
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
  protected VisualSegment() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public VisualSegment(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public VisualSegment(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public VisualSegment(JCas jcas, int begin, int end) {
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
  //* Feature: semanticType

  /** getter for semanticType - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSemanticType() {
    if (VisualSegment_Type.featOkTst && ((VisualSegment_Type)jcasType).casFeat_semanticType == null)
      jcasType.jcas.throwFeatMissing("semanticType", "info.chenli.mooc.semantic.types.VisualSegment");
    return jcasType.ll_cas.ll_getStringValue(addr, ((VisualSegment_Type)jcasType).casFeatCode_semanticType);}
    
  /** setter for semanticType - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSemanticType(String v) {
    if (VisualSegment_Type.featOkTst && ((VisualSegment_Type)jcasType).casFeat_semanticType == null)
      jcasType.jcas.throwFeatMissing("semanticType", "info.chenli.mooc.semantic.types.VisualSegment");
    jcasType.ll_cas.ll_setStringValue(addr, ((VisualSegment_Type)jcasType).casFeatCode_semanticType, v);}    
   
    
  //*--------------*
  //* Feature: startTime

  /** getter for startTime - gets 
   * @generated
   * @return value of the feature 
   */
  public long getStartTime() {
    if (VisualSegment_Type.featOkTst && ((VisualSegment_Type)jcasType).casFeat_startTime == null)
      jcasType.jcas.throwFeatMissing("startTime", "info.chenli.mooc.semantic.types.VisualSegment");
    return jcasType.ll_cas.ll_getLongValue(addr, ((VisualSegment_Type)jcasType).casFeatCode_startTime);}
    
  /** setter for startTime - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setStartTime(long v) {
    if (VisualSegment_Type.featOkTst && ((VisualSegment_Type)jcasType).casFeat_startTime == null)
      jcasType.jcas.throwFeatMissing("startTime", "info.chenli.mooc.semantic.types.VisualSegment");
    jcasType.ll_cas.ll_setLongValue(addr, ((VisualSegment_Type)jcasType).casFeatCode_startTime, v);}    
   
    
  //*--------------*
  //* Feature: endTime

  /** getter for endTime - gets 
   * @generated
   * @return value of the feature 
   */
  public long getEndTime() {
    if (VisualSegment_Type.featOkTst && ((VisualSegment_Type)jcasType).casFeat_endTime == null)
      jcasType.jcas.throwFeatMissing("endTime", "info.chenli.mooc.semantic.types.VisualSegment");
    return jcasType.ll_cas.ll_getLongValue(addr, ((VisualSegment_Type)jcasType).casFeatCode_endTime);}
    
  /** setter for endTime - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setEndTime(long v) {
    if (VisualSegment_Type.featOkTst && ((VisualSegment_Type)jcasType).casFeat_endTime == null)
      jcasType.jcas.throwFeatMissing("endTime", "info.chenli.mooc.semantic.types.VisualSegment");
    jcasType.ll_cas.ll_setLongValue(addr, ((VisualSegment_Type)jcasType).casFeatCode_endTime, v);}    
  }

    
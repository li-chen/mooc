
/* First created by JCasGen Mon Oct 19 14:51:56 EDT 2015 */
package info.chenli.mooc.semantic.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Mon Oct 19 16:33:46 EDT 2015
 * @generated */
public class VisualSegment_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (VisualSegment_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = VisualSegment_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new VisualSegment(addr, VisualSegment_Type.this);
  			   VisualSegment_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new VisualSegment(addr, VisualSegment_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = VisualSegment.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("info.chenli.mooc.semantic.types.VisualSegment");
 
  /** @generated */
  final Feature casFeat_semanticType;
  /** @generated */
  final int     casFeatCode_semanticType;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getSemanticType(int addr) {
        if (featOkTst && casFeat_semanticType == null)
      jcas.throwFeatMissing("semanticType", "info.chenli.mooc.semantic.types.VisualSegment");
    return ll_cas.ll_getStringValue(addr, casFeatCode_semanticType);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSemanticType(int addr, String v) {
        if (featOkTst && casFeat_semanticType == null)
      jcas.throwFeatMissing("semanticType", "info.chenli.mooc.semantic.types.VisualSegment");
    ll_cas.ll_setStringValue(addr, casFeatCode_semanticType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_startTime;
  /** @generated */
  final int     casFeatCode_startTime;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public long getStartTime(int addr) {
        if (featOkTst && casFeat_startTime == null)
      jcas.throwFeatMissing("startTime", "info.chenli.mooc.semantic.types.VisualSegment");
    return ll_cas.ll_getLongValue(addr, casFeatCode_startTime);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setStartTime(int addr, long v) {
        if (featOkTst && casFeat_startTime == null)
      jcas.throwFeatMissing("startTime", "info.chenli.mooc.semantic.types.VisualSegment");
    ll_cas.ll_setLongValue(addr, casFeatCode_startTime, v);}
    
  
 
  /** @generated */
  final Feature casFeat_endTime;
  /** @generated */
  final int     casFeatCode_endTime;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public long getEndTime(int addr) {
        if (featOkTst && casFeat_endTime == null)
      jcas.throwFeatMissing("endTime", "info.chenli.mooc.semantic.types.VisualSegment");
    return ll_cas.ll_getLongValue(addr, casFeatCode_endTime);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setEndTime(int addr, long v) {
        if (featOkTst && casFeat_endTime == null)
      jcas.throwFeatMissing("endTime", "info.chenli.mooc.semantic.types.VisualSegment");
    ll_cas.ll_setLongValue(addr, casFeatCode_endTime, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public VisualSegment_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_semanticType = jcas.getRequiredFeatureDE(casType, "semanticType", "uima.cas.String", featOkTst);
    casFeatCode_semanticType  = (null == casFeat_semanticType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_semanticType).getCode();

 
    casFeat_startTime = jcas.getRequiredFeatureDE(casType, "startTime", "uima.cas.Long", featOkTst);
    casFeatCode_startTime  = (null == casFeat_startTime) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_startTime).getCode();

 
    casFeat_endTime = jcas.getRequiredFeatureDE(casType, "endTime", "uima.cas.Long", featOkTst);
    casFeatCode_endTime  = (null == casFeat_endTime) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_endTime).getCode();

  }
}



    
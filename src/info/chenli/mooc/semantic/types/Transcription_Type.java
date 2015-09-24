
/* First created by JCasGen Thu Sep 24 11:05:28 EDT 2015 */
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
 * Updated by JCasGen Thu Sep 24 17:21:05 EDT 2015
 * @generated */
public class Transcription_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Transcription_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Transcription_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Transcription(addr, Transcription_Type.this);
  			   Transcription_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Transcription(addr, Transcription_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Transcription.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("info.chenli.mooc.semantic.types.Transcription");
 
  /** @generated */
  final Feature casFeat_StartTime;
  /** @generated */
  final int     casFeatCode_StartTime;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public long getStartTime(int addr) {
        if (featOkTst && casFeat_StartTime == null)
      jcas.throwFeatMissing("StartTime", "info.chenli.mooc.semantic.types.Transcription");
    return ll_cas.ll_getLongValue(addr, casFeatCode_StartTime);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setStartTime(int addr, long v) {
        if (featOkTst && casFeat_StartTime == null)
      jcas.throwFeatMissing("StartTime", "info.chenli.mooc.semantic.types.Transcription");
    ll_cas.ll_setLongValue(addr, casFeatCode_StartTime, v);}
    
  
 
  /** @generated */
  final Feature casFeat_EndTime;
  /** @generated */
  final int     casFeatCode_EndTime;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public long getEndTime(int addr) {
        if (featOkTst && casFeat_EndTime == null)
      jcas.throwFeatMissing("EndTime", "info.chenli.mooc.semantic.types.Transcription");
    return ll_cas.ll_getLongValue(addr, casFeatCode_EndTime);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setEndTime(int addr, long v) {
        if (featOkTst && casFeat_EndTime == null)
      jcas.throwFeatMissing("EndTime", "info.chenli.mooc.semantic.types.Transcription");
    ll_cas.ll_setLongValue(addr, casFeatCode_EndTime, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Index;
  /** @generated */
  final int     casFeatCode_Index;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getIndex(int addr) {
        if (featOkTst && casFeat_Index == null)
      jcas.throwFeatMissing("Index", "info.chenli.mooc.semantic.types.Transcription");
    return ll_cas.ll_getIntValue(addr, casFeatCode_Index);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIndex(int addr, int v) {
        if (featOkTst && casFeat_Index == null)
      jcas.throwFeatMissing("Index", "info.chenli.mooc.semantic.types.Transcription");
    ll_cas.ll_setIntValue(addr, casFeatCode_Index, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Transcription_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_StartTime = jcas.getRequiredFeatureDE(casType, "StartTime", "uima.cas.Long", featOkTst);
    casFeatCode_StartTime  = (null == casFeat_StartTime) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_StartTime).getCode();

 
    casFeat_EndTime = jcas.getRequiredFeatureDE(casType, "EndTime", "uima.cas.Long", featOkTst);
    casFeatCode_EndTime  = (null == casFeat_EndTime) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_EndTime).getCode();

 
    casFeat_Index = jcas.getRequiredFeatureDE(casType, "Index", "uima.cas.Integer", featOkTst);
    casFeatCode_Index  = (null == casFeat_Index) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Index).getCode();

  }
}



    
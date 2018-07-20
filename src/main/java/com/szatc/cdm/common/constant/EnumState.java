/*
 *@项目名称: CDM 深圳机场系统决策系统
 *@文件名称: EnumState.java
 *@Copyright: 2009-2010 SZATCTEE All Rights Reserved.
 *注意：本内容仅限于 深圳市空管技术装备工程有限公司 内部传阅，
 *	   禁止外泄以及用于其他的商业目的
*/

package com.szatc.cdm.common.constant;

/**
 * <pre>
 * 航班状态转换枚举
 * 由于可能同时具有多个状态，多个状态时将多个状态相加即可，如已发FPL报和已发DEP报，第4、5位为1，值为8+16=24
 * Release状态即是管制员已经处理好各种计划报文，确定计划的有效性后的状态，此时计划可以打印，发布到其他相关部门
 * [EnumDescription("未知状态")]
 * </pre>
 * @author    李选东
 * @version   V1.00 
 * @date      Mar 29, 2011
 */
public enum EnumState {
	
    /**[EnumDescription("未知状态")] Unknow(0x0) : 0  */
    Unknow(0x0),
    /**[EnumDescription("计划生成初始状态")] Plan (0x1) : 1 */
    Plan (0x1), 
    /**[EnumDescription("PLN取消航班计划")] PLN_CNL (0x4) : 2*/
    PLN_CNL (0x4),  
    /**[EnumDescription("已发PLN报,公司计划")] PLN (0x10) : 4*/
    PLN (0x10),  
    /**[EnumDescription("计划发布状态")] Release (0x20) : 5*/
    Release (0x20),  
    /**[EnumDescription("已发FPL报")] FPL (0x40) : 6*/
    FPL (0x40),  
    /**[EnumDescription("已发CHG报")] CHG (0x80) : 7*/
    CHG (0x80),  
    /**[EnumDescription("CNL取消")] CNL (0x100) : 8 取消FPL*/
    CNL (0x100),            
    /**[EnumDescription("已发DLA报")] DLA (0x200) : 9*/
    DLA (0x200),  
    /**[EnumDescription("已发CPL报")] CPL (0x400) : 10*/
    CPL (0x400),  
    /**[EnumDescription("已发EST报")] EST (0x800) : 11*/
    EST (0x800),  
    /**[EnumDescription("已发CDN报")] CDN (0x1000) : 12*/
    CDN (0x1000), 
    /**[EnumDescription("已发ACP报")] ACP (0x2000) : 13*/
    ACP (0x2000),  
    /**[EnumDescription("已发LAM报")] LAM (0x4000) : 14*/
    LAM (0x4000),  
    /**[EnumDescription("已发RQP报")] RQP (0x8000) : 15*/
    RQP (0x8000),  
    /**[EnumDescription("已发RQS报")] RQS (0x10000) : 16*/
    RQS (0x10000),  
    /**[EnumDescription("已发SPL报")] SPL (0x20000) : 17*/
    SPL (0x20000),  
    /**[EnumDescription("已发ALR报")] ALR (0x80000) : 19*/
    ALR (0x80000),  
    /**[EnumDescription("已发RCF报")] RCF (0x100000): 20*/
    RCF (0x100000),  
    /**[EnumDescription("备降")] ALTN (0x200000) : 21 -18 RMK ALTERNATE 备降外场*/
    ALTN (0x200000),  
    /**[EnumDescription("备降本场")] ALN (0x400000) : 21 -18 RMK ALTERNATE*/
    ALN (0x400000),  
    /**[EnumDescription("返航")] RTN (0x800000) : 23 -18 RMK RETURN*/
    RTN (0x800000),  
    /**[EnumDescription("人工设置结束状态，该航班已经不可能再执行这个任务时候设置，或者没有收到落地报人工设置为结束")] ARRManual (0x1000000) : 24*/
    ARRManual (0x1000000),  
    /**[EnumDescription("已发DEP报")] DEP (0x2000000) : 25*/
    DEP (0x2000000),
    /**[EnumDescription("已发ARR报")] ARR (0x4000000) : 26，已经落地的航班就可以不关注 */
    ARR (0x4000000), 
    /**[EnumDescription("返航备降后的航班，系统标记结束")] END (0x8000000): 27*/
    END (0x8000000),  
    /**[EnumDescription("人工设置航班取消")] ABS (0x10000000) : 28*/
    ABS (0x10000000),  
    /**[EnumDescription("已发SitaCLR放行报")] SitaCLR (0x20000000) : 29*/
    SitaCLR (0x20000000), 
    /**[EnumDescription("MVT")] MVT (0x40000000) :30*/
    MVT (0x40000000);  
    
    /**
     * 十六进制 hexValue
     */
    private int hexValue;
    
    /**
     * 构造函数〈一句话功能简述〉
     * @param hexValue 
     */
    EnumState(int hexValue){
    	this.hexValue = hexValue;
    }
    
    /**
     * 获取十六进制字符
     * @return String 
     */
    public String getHexStringValue(){
    	return Integer.toHexString(this.hexValue);
    }
  
    /**
     * 获取十六进制数值
     * @return int 
     */
    public int getValue(){
    	return this.hexValue;
    }
    
    /**
     * 获取十六进制字符
     * @return String 
     */
    public String getValueString(){
    	return Integer.toString(getValue());
    }
    
    /**
     * 获取二进制字符
     * @return String 
     */
    public String getBinaryValue(){
    	return Integer.toBinaryString(hexValue);
    }
    
    public static void main(String[] args){
    	System.out.println(EnumState.Plan.getBinaryValue());
    }
}

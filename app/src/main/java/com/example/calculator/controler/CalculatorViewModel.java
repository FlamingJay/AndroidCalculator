package com.example.calculator.controler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.calculator.algorithm.MethodToCal;

/**
 * @author jay
 * 表示数据view模型
 */
public class CalculatorViewModel extends ViewModel {
    /**
     * 主数值，用户正在操作的数
     */
    private MutableLiveData<String> mainNum;

    /**
     * 当前计算的式子
     */
    private MutableLiveData<String> equation;

    /**
     * 当前符号
     */
    public String sign = "";

    /**
     * 临时值，当出现运算符号时，其来代表主数值进行显示然后将主数值重置；出现等号时，代表表达式计算结果
     */
    public String tmp = "";

    /**
     * 表示上一个等式的结果
     */
    public String ans = "";

    /**
     * 获取主数值
     * @return
     */
    public MutableLiveData<String> getMainNum() {
        if (mainNum == null) {
            mainNum = new MutableLiveData<>();
            mainNum.setValue("0");
        }
        return mainNum;
    }

    /**
     * 设置主数值
     * @param num
     */
    public void setMainNum(String num) {
        if ("0".equals(mainNum.getValue())) {
            mainNum.setValue(num);
        } else {
            mainNum.setValue(mainNum.getValue() + num);
        }
    }

    /**
     * 重置主数值
     */
    public void resetMainNum() {
        mainNum.setValue("0");
    }

    /**
     * 获取式子
     * @return
     */
    public MutableLiveData<String> getEquation() {
        if (equation == null) {
            equation = new MutableLiveData<>();
            equation.setValue("");
        }
        return equation;
    }

    /**
     * 设置式子
     * @param eq
     */
    public void setEquation(String eq) {
        if ("".equals(equation.getValue())) {
            equation.setValue(eq);
        } else {
            equation.setValue(equation.getValue() + eq);
        }
    }

    /**
     * 重置式子
     */
    public void resetEquation() {
        equation.setValue("");
    }

    /**
     * 重置符号
     */
    public void resetSign() {
        this.sign = "";
    }

    /**
     * 进行字符串的四则运算
     * @param expr
     * @return
     * @throws Exception
     */
    public String calculate(String expr) throws Exception {
        return MethodToCal.calculate(expr);
    }

}

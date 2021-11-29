package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.calculator.controler.CalculatorViewModel;
import com.example.calculator.databinding.ActivityMainBinding;
import com.example.calculator.controler.SoundPlayer;
import com.example.calculator.utils.Constants;

import java.util.Objects;

/**
 * @author jay
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; // 储存组件类
    private CalculatorViewModel myViewModel; // 数据模型
    private SoundPlayer soundPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        soundPlayer = new SoundPlayer(this.getApplicationContext());
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main); // 获取所有控件

        myViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(CalculatorViewModel.class);

        // 监听主数值的改变，并在myTextView上显示
        myViewModel.getMainNum().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // 一旦使用了运算符，则将mainNum复位，而之前的值时存在tmp里面
                if ("".equals(myViewModel.sign) || ".".equals(myViewModel.sign)) {
                    binding.textViewMainNum.setText(myViewModel.getMainNum().getValue());
                    System.out.println("s");
                } else {
                    binding.textViewMainNum.setText(myViewModel.tmp);
                    System.out.println("s");
                }
            }
        });

        // 监听等式的改变，并在textView3上显示
        myViewModel.getEquation().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textViewExptr.setText(myViewModel.getEquation().getValue());
            }
        });

        binding.button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eqLen = myViewModel.getEquation().getValue().length();
                if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    myViewModel.resetEquation();
                }
                soundPlayer.play(R.raw.num0);
                myViewModel.resetSign();
                myViewModel.setMainNum("0");
                myViewModel.setEquation("0");
            }
        });
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eqLen = myViewModel.getEquation().getValue().length();
                if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    myViewModel.resetEquation();
                }
                soundPlayer.play(R.raw.num1);
                myViewModel.resetSign();
                myViewModel.setMainNum("1");
                myViewModel.setEquation("1");
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eqLen = myViewModel.getEquation().getValue().length();
                if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    myViewModel.resetEquation();
                }
                soundPlayer.play(R.raw.num2);
                myViewModel.resetSign();
                myViewModel.setMainNum("2");
                myViewModel.setEquation("2");
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eqLen = myViewModel.getEquation().getValue().length();
                if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    myViewModel.resetEquation();
                }
                soundPlayer.play(R.raw.num3);
                myViewModel.resetSign();
                myViewModel.setMainNum("3");
                myViewModel.setEquation("3");
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eqLen = myViewModel.getEquation().getValue().length();
                if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    myViewModel.resetEquation();
                }
                soundPlayer.play(R.raw.num4);
                myViewModel.resetSign();
                myViewModel.setMainNum("4");
                myViewModel.setEquation("4");
            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eqLen = myViewModel.getEquation().getValue().length();
                if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    myViewModel.resetEquation();
                }
                soundPlayer.play(R.raw.num5);
                myViewModel.resetSign();
                myViewModel.setMainNum("5");
                myViewModel.setEquation("5");
            }
        });
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eqLen = myViewModel.getEquation().getValue().length();
                if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    myViewModel.resetEquation();
                }
                soundPlayer.play(R.raw.num6);
                myViewModel.resetSign();
                myViewModel.setMainNum("6");
                myViewModel.setEquation("6");
            }
        });
        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eqLen = myViewModel.getEquation().getValue().length();
                if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    myViewModel.resetEquation();
                }
                soundPlayer.play(R.raw.num7);
                myViewModel.resetSign();
                myViewModel.setMainNum("7");
                myViewModel.setEquation("7");
            }
        });
        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eqLen = myViewModel.getEquation().getValue().length();
                if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    myViewModel.resetEquation();
                }
                soundPlayer.play(R.raw.num8);
                myViewModel.resetSign();
                myViewModel.setMainNum("8");
                myViewModel.setEquation("8");
            }
        });
        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eqLen = myViewModel.getEquation().getValue().length();
                if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    myViewModel.resetEquation();
                }
                soundPlayer.play(R.raw.num9);
                myViewModel.resetSign();
                myViewModel.setMainNum("9");
                myViewModel.setEquation("9");
            }
        });

        /**
         * 小数点的监听
         */
        binding.buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eqLen = myViewModel.getEquation().getValue().length();
                if (eqLen > 1 && '.' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    soundPlayer.play(R.raw.plus);
                } else if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                    soundPlayer.play(R.raw.point);
                    myViewModel.sign = ".";
                    myViewModel.resetMainNum();
                    myViewModel.setMainNum("0.");
                    myViewModel.resetEquation();
                    myViewModel.setEquation("0.");
                } else {
                    soundPlayer.play(R.raw.point);
                    myViewModel.sign = ".";

                    if ("0".equals(myViewModel.getMainNum().getValue())){
                        if ("".equals(myViewModel.getEquation().getValue()) ||
                                Constants.OPERATIONS.contains(myViewModel.getEquation().getValue().charAt(eqLen - 1))) {
                            myViewModel.setMainNum("0.");
                            myViewModel.setEquation("0.");
                        } else if ("0".equals(myViewModel.getEquation().getValue())){
                            myViewModel.setMainNum("0.");
                            myViewModel.setEquation(".");
                        }
                    } else {
                        myViewModel.setMainNum(".");
                        myViewModel.setEquation(".");
                    }
                }

            }
        });

        /**
         * 加号的监听，这时候主数值变成0
         */
        binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!"".equals(myViewModel.getEquation().getValue())) {
                    int eqLen = myViewModel.getEquation().getValue().length();
                    if (eqLen > 1 && '+' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                        soundPlayer.play(R.raw.plus);
                    } else {
                        soundPlayer.play(R.raw.plus);

                        if ("=".equals(myViewModel.sign)) {
                            myViewModel.ans = "" + myViewModel.tmp;
                            myViewModel.getEquation().setValue("ANS");
                            myViewModel.getMainNum().setValue("ANS");
                        }

                        myViewModel.sign = "+";
                        myViewModel.tmp = myViewModel.getMainNum().getValue();
                        myViewModel.resetMainNum();
                        myViewModel.setEquation("+");
                    }
                }
            }
        });

        /**
         * 减号的监听
         */
        binding.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(myViewModel.getEquation().getValue())) {
                    int eqLen = myViewModel.getEquation().getValue().length();
                    if (eqLen > 1 && '-' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                        soundPlayer.play(R.raw.plus);
                    } else {
                        soundPlayer.play(R.raw.minus);

                        if ("=".equals(myViewModel.sign)) {
                            myViewModel.ans = "" + myViewModel.tmp;
                            myViewModel.getEquation().setValue("ANS");
                            myViewModel.getMainNum().setValue("ANS");
                        }

                        myViewModel.sign = "-";
                        myViewModel.tmp = myViewModel.getMainNum().getValue();
                        myViewModel.resetMainNum();
                        myViewModel.setEquation("-");
                    }
                }
            }
        });

        /**
         * 乘号的监听
         */
        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(myViewModel.getEquation().getValue())) {
                    int eqLen = myViewModel.getEquation().getValue().length();
                    if (eqLen > 1 && '*' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                        soundPlayer.play(R.raw.plus);
                    } else {
                        soundPlayer.play(R.raw.multiply);

                        if ("=".equals(myViewModel.sign)) {
                            myViewModel.ans = "" + myViewModel.tmp;
                            myViewModel.getEquation().setValue("ANS");
                            myViewModel.getMainNum().setValue("ANS");
                        }

                        myViewModel.sign = "*";
                        myViewModel.tmp = myViewModel.getMainNum().getValue();
                        myViewModel.resetMainNum();
                        myViewModel.setEquation("*");
                    }
                }
            }
        });

        /**
         * 除号的监听
         */
        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(myViewModel.getEquation().getValue())) {
                    int eqLen = myViewModel.getEquation().getValue().length();
                    if (eqLen > 1 && '/' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                        soundPlayer.play(R.raw.plus);
                    } else {
                        soundPlayer.play(R.raw.divide);

                        if ("=".equals(myViewModel.sign)) {
                            myViewModel.ans = "" + myViewModel.tmp;
                            myViewModel.getEquation().setValue("ANS");
                            myViewModel.getMainNum().setValue("ANS");
                        }

                        myViewModel.sign = "/";
                        myViewModel.tmp = myViewModel.getMainNum().getValue();
                        myViewModel.resetMainNum();
                        myViewModel.setEquation("/");
                    }
                }
            }
        });

        /**
         * 四则运算计算
         */
        binding.buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(myViewModel.getEquation().getValue())) {
                    int eqLen = myViewModel.getEquation().getValue().length();
                    if (eqLen > 1 && '=' == myViewModel.getEquation().getValue().charAt(eqLen-1)) {
                        soundPlayer.play(R.raw.equal);
                    } else {
                        soundPlayer.play(R.raw.equal);
                        myViewModel.sign = "=";
                        try {
                            myViewModel.tmp = myViewModel.calculate(Objects.requireNonNull(myViewModel.getEquation().getValue()).replace("ANS", myViewModel.ans));
                            myViewModel.setEquation("=");
                            // 将mainNum重置
                            myViewModel.resetMainNum();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        /**
         * 清除键
         */
        binding.buttonClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.play(R.raw.clear);
                myViewModel.resetSign();
                myViewModel.resetMainNum();
                myViewModel.resetEquation();
            }
        });

        /**
         * 左括号
         */
        binding.buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setEquation("(");
            }
        });

        /**
         *  右括号
         */
        binding.buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setEquation(")");
            }
        });

        /**
         * 回退符
         */
        binding.buttonBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.play(R.raw.delete);
                if ("".equals(myViewModel.getEquation().getValue())) {

                } else if ("ANS".equals(myViewModel.getEquation().getValue())) {
                    myViewModel.resetEquation();
                    myViewModel.resetMainNum();
                } else {
                    // 删掉equation/mainNum最后一个字符，需要区分情况
                    int exprLen = myViewModel.getEquation().getValue().length();
                    if (Character.isDigit(myViewModel.getEquation().getValue().charAt(exprLen-1)) ||
                            '.' == (myViewModel.getEquation().getValue().charAt(exprLen-1))
                    ) {
                        if (myViewModel.getEquation().getValue().length() == 1) {
                            myViewModel.resetEquation();
                        } else {
                            myViewModel.getEquation().setValue(myViewModel.getEquation().getValue().substring(0, exprLen-1));
                        }

                        if (myViewModel.getMainNum().getValue().length() == 1) {
                            myViewModel.resetMainNum();
                        } else {
                            myViewModel.getMainNum().setValue(myViewModel.getMainNum().getValue().substring(0, myViewModel.getMainNum().getValue().length()-1));
                        }
                    } else {
                        myViewModel.getEquation().setValue(myViewModel.getEquation().getValue().substring(0, exprLen-1));
                    }
                }
            }
        });
    }
}
package com.test1;

/**
 * Math类方法的测试
 */
public class Test2Math {
    public static void main(String[] args) {

        //比大小
        System.out.println(Math.max(Math.E,Math.PI));
        System.out.println(Math.min(Math.PI,Math.E));
        //0-1的随机数
        System.out.println(Math.random());
        //四舍五入
        System.out.println(Math.round(1.5));

        System.out.println("---------------");

        //sin(弧度制)、cos（）、tan（）、
        System.out.println(Math.sin(Math.PI/2));
        System.out.println(Math.cos(Math.PI/4));
        System.out.println(Math.tan(Math.PI/3));
        //arcsin(x),arccos(x),arctan(x)
        System.out.println(Math.asin(1));
        System.out.println(Math.acos(1));
        System.out.println(Math.atan(100));
        //双曲函数
        System.out.println(Math.sinh(1));
        System.out.println(Math.cosh(1));
        System.out.println(Math.tanh(1));
        //atan2(a,b)即arctan(1/2)
        System.out.println(Math.atan2(1,2));

        System.out.println("--------------------");

        //绝对值|a|
        System.out.println(Math.abs(-12));
        //copySign(f1,f2)，返回|f1|*f2/|f2|
        System.out.println(Math.copySign(-1.2,-2.4));
        //sqrt()开平方，cbrt()开立方
        System.out.println(Math.sqrt(4));
        System.out.println(Math.cbrt(-8));
        //幂函数pow(a,b)=a^b
        System.out.println(Math.pow(2,3));
        //ceil(x)取大于x的最小整数，floor(x)取小于x的最大整数
        System.out.println(Math.ceil(3.15));
        System.out.println(Math.floor(3.98));
        //floorDiv(x,y)返回上限模数，floorMod(x,y)返回下限模数
        System.out.println(Math.floorDiv(-99,-2));
        System.out.println(Math.floorMod(-34,5));
        //exp(x)即e^x，expm1(x)即e^x-1
        System.out.println(Math.exp(2));
        System.out.println(Math.expm1(2));
        //a+b,a-b,a*b,x+1,x-1,x+1,-x
        System.out.println(Math.addExact(2,3));
        System.out.println(Math.subtractExact(4,8));
        System.out.println(Math.multiplyExact(2,3));
        System.out.println(Math.incrementExact(5));
        System.out.println(Math.decrementExact(5));
        System.out.println(Math.negateExact(5));
        //long转int
        System.out.println(Math.toIntExact(12));
        //ln(x),lg(x),ln(x)比第一个在x->1时更准确
        System.out.println(Math.log(Math.E));
        System.out.println(Math.log10(10));
        System.out.println(Math.log1p(1));
        //getExponent(x)=(int)sqrt(x)
        System.out.println(Math.getExponent(15));
        //hypot(a,b)=sqrt(x^2+y^2)即勾股定理
        System.out.println(Math.hypot(3,4));
        //round(d)的更精确
        System.out.println(Math.rint(9.49));
        //nextUp(d),nextDown(d)，大于和小于d取与之最近的浮点值
        System.out.println(Math.nextUp(7.8));
        System.out.println(Math.nextDown(7.8));
        //signum(x),if x>0,return 1,else if x=0,return 0,else if x<0,return -1
        System.out.println(Math.signum(10));
        //scalb(a,b)=a*2^b
        System.out.println(Math.scalb(1.2,2));
        //toDegrees(x)弧度转角度，toRadians(x)角度转弧度
        System.out.println(Math.toDegrees(Math.PI));
        System.out.println(Math.toRadians(180));
        //ulp(x),x与之浮点值较大的一边的差值
        System.out.println(Math.ulp(6.5));
        //用于浮点数的取余IEEEremainder(d1,d2),d1%d2,即d1-d2*n
        System.out.println(Math.IEEEremainder(6.6,1.2));
        //返回第二个参数方向上第一个参数附近的浮点数。如果两个参数比较为相等，则返回第二个参数。
        System.out.println(Math.nextAfter(7.80,7.79));
    }
}

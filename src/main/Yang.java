package main;
import main.methods.Pattern;
import main.methods.TM;
public class Yang {

    public static void main(String[] args) throws Exception {

        // 参数1：sampling method，origin表示原始数据、sampling1-4表示4种参数
        String exp_data_path = "Yang_exp_data\\smotetomek\\";


        //arff文件的准备
        TM tm = new TM();
        tm.originPath = exp_data_path;
        tm.prepareData();
        //进行预测
        new TM().predict(exp_data_path);
    }
}

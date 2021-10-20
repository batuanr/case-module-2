package controller;

import model.Payroll;
import storage.InputOutFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class PayrollManage implements GeneralManage<Payroll> {
    private InputOutFile inputOutFile = InputOutFile.getInstance();
    private List<Payroll> payrollList = new ArrayList<>();
    private final String PAYROLL_FILE = "payroll.obj";

    public PayrollManage() {
        this.payrollList = inputOutFile.readToFile(PAYROLL_FILE);
    }

    public List<Payroll> getPayrollList() {
        return payrollList;
    }

    public void setPayrollList(List<Payroll> payrollList) {
        this.payrollList = payrollList;
    }

    @Override
    public void add(Payroll payroll) {
        payrollList.add(payroll);
        inputOutFile.writeFile(PAYROLL_FILE, payrollList);
    }

    @Override
    public Payroll find(String code) throws FileNotFoundException {
        for (Payroll payroll: payrollList){
            if (payroll.getCode().equals(code)){
                return payroll;
            }
        }
        throw new FileNotFoundException();
    }

    @Override
    public void edit(String code, Payroll payroll) {
        for (int i = 0; i < payrollList.size(); i++) {
            if (payrollList.get(i).getCode().equals(code)){
                payrollList.set(i, payroll);
                inputOutFile.writeFile(PAYROLL_FILE, payrollList);
                break;
            }
        }
    }

    @Override
    public Payroll remove(String code) throws FileNotFoundException {
        Payroll payroll = find(code);
        payrollList.remove(payroll);
        inputOutFile.writeFile(PAYROLL_FILE, payrollList);
        return payroll;
    }
    public List<Payroll> getPayrollOneMonth(int month){
        List<Payroll> payrolls = new ArrayList<>();
        for (Payroll payroll: payrollList){
            if (payroll.getMonth() == month){
                payrolls.add(payroll);
            }
        }
        return payrolls;
    }

}

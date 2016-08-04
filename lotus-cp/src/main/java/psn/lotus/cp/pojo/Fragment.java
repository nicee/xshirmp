package psn.lotus.cp.pojo;

import java.io.Serializable;

/**
 * 每期碎片
 *
 * @author xjl
 * @project lotus
 * @time 2016/8/4 17:09
 */
public class Fragment implements Serializable {

    private static final long serialVersionUID = 8285487350039849151L;

    private String serialNo;

    private Long number;

    private int tenNo;

    private int unitNo;


    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public int getTenNo() {
        return tenNo;
    }

    public void setTenNo(int tenNo) {
        this.tenNo = tenNo;
    }

    public int getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(int unitNo) {
        this.unitNo = unitNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fragment fragment = (Fragment) o;

        if (tenNo != fragment.tenNo) return false;
        return unitNo == fragment.unitNo;

    }

    @Override
    public int hashCode() {
        int result = tenNo;
        result = 31 * result + unitNo;
        return result;
    }

}

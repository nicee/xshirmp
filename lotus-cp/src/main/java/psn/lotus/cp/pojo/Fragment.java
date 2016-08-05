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

    private static final long serialVersionUID = 3007915831379181190L;

    private String serial;

    private Integer serialNo;

    private Integer number;

    private int tenNo;

    private int unitNo;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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

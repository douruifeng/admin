package wcaa.pojo;

import javax.persistence.Id;

public class Post {
    /**
     * 岗位ID
     */
    @Id
    private Integer id;

    /**
     * 岗位名称
     */
    private String postname;

    /**
     * 岗位编码
     */
    private String postcode;

    /**
     * 获取岗位ID
     *
     * @return id - 岗位ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置岗位ID
     *
     * @param id 岗位ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取岗位名称
     *
     * @return postname - 岗位名称
     */
    public String getPostname() {
        return postname;
    }

    /**
     * 设置岗位名称
     *
     * @param postname 岗位名称
     */
    public void setPostname(String postname) {
        this.postname = postname;
    }

    /**
     * 获取岗位编码
     *
     * @return postcode - 岗位编码
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 设置岗位编码
     *
     * @param postcode 岗位编码
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
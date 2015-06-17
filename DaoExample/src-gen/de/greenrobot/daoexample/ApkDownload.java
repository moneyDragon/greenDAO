package de.greenrobot.daoexample;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table APK_DOWNLOAD.
 */
public class ApkDownload {

    private String package_name;
    private Integer version;
    private String tip;
    private String name;
    private Integer downing_state;
    private Integer total_filesize;
    private Integer download_beginning;
    private Integer downloaded_size;
    private Integer download_percent;
    private Integer create_time;
    private String download_url;
    private String save_dir;
    private String save_name;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public ApkDownload() {
    }

    public ApkDownload(String package_name, Integer version, String tip, String name, Integer downing_state, Integer total_filesize, Integer download_beginning, Integer downloaded_size, Integer download_percent, Integer create_time, String download_url, String save_dir, String save_name) {
        this.package_name = package_name;
        this.version = version;
        this.tip = tip;
        this.name = name;
        this.downing_state = downing_state;
        this.total_filesize = total_filesize;
        this.download_beginning = download_beginning;
        this.downloaded_size = downloaded_size;
        this.download_percent = download_percent;
        this.create_time = create_time;
        this.download_url = download_url;
        this.save_dir = save_dir;
        this.save_name = save_name;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDowning_state() {
        return downing_state;
    }

    public void setDowning_state(Integer downing_state) {
        this.downing_state = downing_state;
    }

    public Integer getTotal_filesize() {
        return total_filesize;
    }

    public void setTotal_filesize(Integer total_filesize) {
        this.total_filesize = total_filesize;
    }

    public Integer getDownload_beginning() {
        return download_beginning;
    }

    public void setDownload_beginning(Integer download_beginning) {
        this.download_beginning = download_beginning;
    }

    public Integer getDownloaded_size() {
        return downloaded_size;
    }

    public void setDownloaded_size(Integer downloaded_size) {
        this.downloaded_size = downloaded_size;
    }

    public Integer getDownload_percent() {
        return download_percent;
    }

    public void setDownload_percent(Integer download_percent) {
        this.download_percent = download_percent;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getSave_dir() {
        return save_dir;
    }

    public void setSave_dir(String save_dir) {
        this.save_dir = save_dir;
    }

    public String getSave_name() {
        return save_name;
    }

    public void setSave_name(String save_name) {
        this.save_name = save_name;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}

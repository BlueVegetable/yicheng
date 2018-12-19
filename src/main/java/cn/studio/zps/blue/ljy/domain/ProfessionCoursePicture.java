package cn.studio.zps.blue.ljy.domain;

public class ProfessionCoursePicture {

	private int id;
	private String path;
	private String url;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path=path;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url=url;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ProfessionCoursePicture professionCoursePicture = (ProfessionCoursePicture) o;

		if(id != professionCoursePicture.id) return false;
		if(path != null ? !path.equals(professionCoursePicture.path) : professionCoursePicture.path !=null) return false;
		if(url != null ? !url.equals(professionCoursePicture.url) : professionCoursePicture.url !=null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (path!=null ? path.hashCode() : 0);
		result = 31 * result + (url!=null ? url.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ProfessionCoursePicture{" +
				"id=" + id +
				", path='" + path + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}
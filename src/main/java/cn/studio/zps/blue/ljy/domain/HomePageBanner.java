package cn.studio.zps.blue.ljy.domain;

public class HomePageBanner {

	private int id;
	private String image;
	private String url;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image=image;
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

		HomePageBanner homePageBanner = (HomePageBanner) o;

		if(id != homePageBanner.id) return false;
		if(image != null ? !image.equals(homePageBanner.image) : homePageBanner.image !=null) return false;
		if(url != null ? !url.equals(homePageBanner.url) : homePageBanner.url !=null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (image!=null ? image.hashCode() : 0);
		result = 31 * result + (url!=null ? url.hashCode() : 0);
		return result;
	}
}
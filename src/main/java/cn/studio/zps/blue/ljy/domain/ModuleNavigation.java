package cn.studio.zps.blue.ljy.domain;

public class ModuleNavigation {

	private int id;
	private String name;
	private String url;
	private int moduleID;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url=url;
	}

	public int getModuleID() {
		return this.moduleID;
	}

	public void setModuleID(int moduleID) {
		this.moduleID=moduleID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ModuleNavigation moduleNavigation = (ModuleNavigation) o;

		if(id != moduleNavigation.id) return false;
		if(name != null ? !name.equals(moduleNavigation.name) : moduleNavigation.name !=null) return false;
		if(url != null ? !url.equals(moduleNavigation.url) : moduleNavigation.url !=null) return false;
		if(moduleID != moduleNavigation.moduleID) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name!=null ? name.hashCode() : 0);
		result = 31 * result + (url!=null ? url.hashCode() : 0);
		result = 31 * result + moduleID;
		return result;
	}
}
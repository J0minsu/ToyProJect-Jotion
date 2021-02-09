package msjo.jotion.zzodeng.domain;

public enum Authority {

    PROJECT_OWNER("프로젝트 오너"),
    MANAGER("매니져"),
    CREW("일원");

    private String title;

    Authority(String s) {
        this.title = s;
    }
}

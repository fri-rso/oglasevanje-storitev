package si.jaklic.adverts;

public class Info {
    String[] clani;
    String opis_projekta;
    String[] mikrostoritve;
    String[] github;
    String[] travis;
    String[] dockerhub;
    String[] internal_mikrostoritve;

    public Info(String[] clani, String opis, String[] mikrostoritve, String[] github, String[] travis, String[] dockerhub, String[] internal_mikrostoritve) {
        this.opis_projekta = opis;
        this.clani = clani;
        this.mikrostoritve = mikrostoritve;
        this.github = github;
        this.travis = travis;
        this.dockerhub = dockerhub;
        this.internal_mikrostoritve = internal_mikrostoritve;
    }

    public String getOpis_projekta() {
        return opis_projekta;
    }

    public void setOpis_projekta(String opis_projekta) {
        this.opis_projekta = opis_projekta;
    }

    public String[] getClani() {
        return clani;
    }

    public void setClani(String[] clani) {
        this.clani = clani;
    }

    public String[] getMikrostoritve() {
        return mikrostoritve;
    }

    public void setMikrostoritve(String[] mikrostoritve) {
        this.mikrostoritve = mikrostoritve;
    }


    public String[] getGithub() {
        return github;
    }

    public void setGithub(String[] github) {
        this.github = github;
    }

    public String[] getTravis() {
        return travis;
    }

    public void setTravis(String[] travis) {
        this.travis = travis;
    }

    public String[] getDockerhub() {
        return dockerhub;
    }

    public void setDockerhub(String[] dockerhub) {
        this.dockerhub = dockerhub;
    }

    public String[] getInternal_mikrostoritve() {
        return internal_mikrostoritve;
    }

    public void setInternal_mikrostoritve(String[] internal_mikrostoritve) {
        this.internal_mikrostoritve = internal_mikrostoritve;
    }
}

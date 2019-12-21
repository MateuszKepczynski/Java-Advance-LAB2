package pl.pjatk.jaz.section;

import java.util.List;
import java.util.Optional;

public interface SectionDAO
{
    List<SectionEntity> getSectionList();
    SectionRequest getSection();
    Optional<SectionEntity> getSectionById(Long sectionId);
    void save(SectionEntity sectionEntity);
    void delete(SectionEntity sectionEntity);
}

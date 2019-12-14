package pl.pjatk.jaz.controller;

import pl.pjatk.jaz.ParamRetriever;
import pl.pjatk.jaz.dao.CategoryDAO;
import pl.pjatk.jaz.entity.CategoryEntity;
import pl.pjatk.jaz.request.CategoryRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class CategoryController
{
    private CategoryRequest categoryRequest;

    @Inject
    CategoryDAO categoryDAO;

    @Inject
    ParamRetriever paramRetriever;

    public List<CategoryEntity> getCategoryList()
    {
        return categoryDAO.getCategoryList();
    }

    public CategoryRequest getCategoryRequest()
    {
        if (categoryRequest == null)
        {
            categoryRequest = createCategoryRequest();
        }
        return categoryRequest;
    }

    private CategoryRequest createCategoryRequest()
    {
        if (paramRetriever.contains("categoryId"))
        {
            var categoryId = paramRetriever.getLong("categoryId");
            var category = categoryDAO.getCategoryById(categoryId).orElseThrow();
            return new CategoryRequest(category);
        }
        return new CategoryRequest();
    }

    public String save()
    {
        var category = new CategoryEntity(categoryRequest.getId(), categoryRequest.getName(), categoryRequest.getDescription());
        category.setSectionId(categoryRequest.getSectionId());
        categoryDAO.save(category);
        return "/list-category.xhtml?faces-redirect=true";
    }

    public String delete()
    {
        var section = categoryDAO.getCategoryById(categoryRequest.getId()).get();
        categoryDAO.delete(section);
        return "/list-category.xhtml?faces-redirect=true";
    }
}

class ListRecipesPage
  include PageObject

  div(:recipes_list, :id => 'recipesList')
  
  page_url :my_page_url
  
  def my_page_url
    SINGLE_APP ? "#{BASE_URL}" : "#{BASE_URL}/recipes"
  end
end

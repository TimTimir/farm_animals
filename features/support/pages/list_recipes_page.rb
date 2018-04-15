class ListRecipesPage
  include PageObject

  div(:recipes_list, :id => 'recipesList')
  
  page_url :my_page_url
  
  def my_page_url
    "#{BASE_URL}/recipes/ui"
  end

  def view_recipe(recipe)
    @browser.image(alt: PANCAKE_RECIPE[:name]).click
  end
end

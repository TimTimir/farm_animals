class AnimalInventoryPage
  include PageObject

  table(:animals, :id => 'animals')

  page_url :my_page_url

  def my_page_url
    "#{BASE_URL}/ui"
  end
end
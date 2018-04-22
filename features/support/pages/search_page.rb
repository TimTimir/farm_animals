class SearchPage
  include PageObject

  text_field(:eid, :id => 'eid')
  button(:search, :id => 'search')

  page_url :my_page_url

  def my_page_url
    "#{BASE_URL}/ui/search"
  end

end
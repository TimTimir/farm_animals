class DetailsPage
  include PageObject

  label(:species, :id => 'species')
  label(:eid, :id => 'eid')

  page_url :my_page_url

  def my_page_url
    "#{BASE_URL}/ui/animal"
  end

end
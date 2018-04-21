class BuyAnimalPage
  include PageObject

  select_list(:species, :id => 'species')
  text_field(:seller, :id => 'seller')
  text_field(:eid, :id => 'eid')
  button(:save, :id => 'save')

  page_url :my_page_url

  def my_page_url
    "#{BASE_URL}/buy"
  end

end
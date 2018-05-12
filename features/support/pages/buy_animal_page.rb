class BuyAnimalPage
  include PageObject

  select_list(:species, :id => 'species')
  text_field(:seller, :id => 'seller')
  text_field(:eid, :id => 'eid')
  button(:save, :id => 'save')

  text_field(:name, :id => 'name')
  radio_button(:male, :value => 'MALE')
  radio_button(:female, :value => 'FEMALE')
  text_field(:race, :id => 'race')
  text_field(:color, :id => 'color')

  page_url :my_page_url

  def my_page_url
    "#{BASE_URL}/ui/buy"
  end

end
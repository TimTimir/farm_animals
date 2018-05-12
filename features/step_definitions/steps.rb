When("I buy a {string} {string} with eid {string} from {string}") do |sex, species, eid, seller|
  visit(BuyAnimalPage) do |page|
    page.species = species.upcase
    page.eid = eid

    page.select_male if sex.upcase.eql?('MALE')
    page.select_female if sex.upcase.eql?('FEMALE')

    page.seller = seller
    page.save
  end
end

When("I buy a {string} {string} with eid {string} from {string} with details:") do |sex, species, eid, seller, details|
  visit(BuyAnimalPage) do |page|
    page.species = species.upcase
    page.eid = eid
    page.seller = seller

    page.select_male if sex.upcase.eql?('MALE')
    page.select_female if sex.upcase.eql?('FEMALE')

    row = details.hashes.first
    page.name = row['Name']
    page.race = row['Race']
    page.color = row['Color']

    page.save
  end
end

Then("the animal with eid {string} is at the farm") do |eid|
  expect(visit(AnimalInventoryPage).animals).to include(eid)
end

Given("a {string} {string} with eid {string} exists on the farm") do |sex, species, eid|
  request = { :species => species.upcase,
              :eid => eid,
              :sex => sex.upcase}

  RestClient::Request.execute method: :put, url: "#{BASE_URL}/api/animals", payload: request.to_json, headers: {:content_type => :json}, user: 'user', password: 'password'
end

When("the animal is reported as dead") do
  on(DetailsPage).report_dead
end

Then("the {string} with eid {string} is no longer on the farm") do |species, eid|
  expect(visit(AnimalInventoryPage).animals).not_to include(eid)
end

When("I search for the animal with eid {string}") do |eid|
  visit(SearchPage) do |page|
    page.eid = eid
    page.search
  end
end

Then("I see details about a {string} with eid {string}") do |species, eid|
  on(DetailsPage) do |page|
    expect(page.species).to be_eql(species.upcase)
    expect(page.eid).to be_eql(eid)
  end
end

Given("I am {string}") do |user|
  visit(LoginPage) do |page|
    page.username = USERS[user][:username]
    page.password = USERS[user][:password]
    page.login
  end
end

And("the details stored for the animal with eid {string} are:") do |eid, details|
  step "I search for the animal with eid \"#{eid}\""
  on(DetailsPage) do |page|
    details.diff!(page.details_element.hashes)
  end
end

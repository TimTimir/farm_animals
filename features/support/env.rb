require 'watir'
require 'page-object'
require 'page-object/page_factory'
require 'rspec/expectations'

#BASE_URL="file://#{Dir.pwd}/features/support/mockups"
BASE_URL="http://localhost:8080/animals/ui"
SCREENSHOTS_DIR="#{Dir.pwd}/target/cucumber"

FileUtils.remove_dir SCREENSHOTS_DIR, true
FileUtils.mkdir_p SCREENSHOTS_DIR

if ENV['HOST'].nil? || ENV['HOST'] == 'localhost'
  browser = Watir::Browser.new :chrome
else
  browser = Watir::Browser.new :chrome, {timeout: 120, url: "http://selenium:4444/wd/hub"}
end

Before do
  @browser = browser
  @browser.cookies.clear
end

After do |scenario|
  if (scenario.failed?)
    time = Time.now.strftime('%Y_%m_%d_%Y_%H_%M_%S_')
    name_of_scenario = time + scenario.name.gsub(/\s+/, "_").gsub("/","_")
    file_path = "#{SCREENSHOTS_DIR}/#{name_of_scenario}.png"
    @browser.screenshot.save file_path
    embed(file_path, "image/png", name_of_scenario)
  end
end


at_exit do
  browser.close
end

World(PageObject::PageFactory)

# set CLICK_DUMMY to true to fake backend
CLICK_DUMMY = true

BASE_URL = "http://localhost:8080"
TMP_DIR = "#{Dir.pwd}/target/cucumber-tmp"
SCREENSHOTS_DIR = "#{TMP_DIR}/screenshots"

MEMBER_DB = "#{TMP_DIR}/members.yaml"

require 'watir'
require 'page-object'
require 'page-object/page_factory'
require 'rspec-expectations'
require 'fileutils'
require 'rest_client'
require 'json'


FileUtils.remove_dir TMP_DIR, true
FileUtils.mkdir_p TMP_DIR

FileUtils.remove_dir SCREENSHOTS_DIR, true
FileUtils.mkdir_p SCREENSHOTS_DIR

caps = Selenium::WebDriver::Remote::Capabilities.chrome(
  chromeOptions: { args: [
#     '--headless', 
     '--window-size=1920,1080' ]})
browser = Watir::Browser.new :chrome, desired_capabilities: caps

Before do
  @browser = browser
  @browser.cookies.clear
end

at_exit do
  browser.close
end

World(PageObject::PageFactory)

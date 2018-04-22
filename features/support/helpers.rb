def clear_data
  url = "#{BASE_URL}/api/animals"
  begin
    RestClient.delete url
  rescue RestClient::ExceptionWithResponse => e
    fail e
  end
end
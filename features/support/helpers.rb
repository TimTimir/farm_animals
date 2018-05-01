def clear_data
  url = "#{BASE_URL}/api/animals"
  begin
    RestClient::Request.execute method: :delete, url: url, user: 'user', password: 'password'
  rescue RestClient::ExceptionWithResponse => e
    fail e
  end
end

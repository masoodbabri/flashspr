require 'rails_helper'

RSpec.describe ReportController, type: :controller do
  describe "GET #index" do
    before :each do
      sign_in FactoryGirl.create(:user)
    end
    it "renders the index" do
      get :index
      expect(response).to have_http_status :ok
    end
  end
end

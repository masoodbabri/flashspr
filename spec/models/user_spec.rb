require 'rails_helper'

RSpec.describe User, type: :model do
  context 'create' do
    it 'creates an Staff' do
      expect(Staff.new(first_name: "first_name",
                       last_name: "last_name",
                       title: "title",
                       email: "email")
      ).to be_valid
    end
  end
end

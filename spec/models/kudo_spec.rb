require 'rails_helper'

RSpec.describe Kudo, type: :model do
  context 'create' do
    it 'creates an kudo' do
      expect(Kudo.create(sender: 'sender', message: 'message')).to be_truthy
    end
  end
end
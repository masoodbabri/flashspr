require 'rails_helper'

describe KudoPolicy do
  subject { KudoPolicy }
  let(:user) { FactoryGirl.build(:user) }
  let(:admin) { FactoryGirl.build(:admin) }

  permissions :destroy? do
    it 'grants access to admin' do
      expect(subject).to permit(admin)
    end

    it 'deniess access to user' do
      expect(subject).not_to permit(user)
    end
  end
end